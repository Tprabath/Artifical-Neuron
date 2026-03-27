package lk.prabhath.neuron;
public final class Logging{

    static enum Status {
        LOG,
        ERROR
    }

    private static Logging l;

    public final static Logging getInstance() {
        if (Logging.l == null) {
            Logging.l = new Logging();
        }

        return Logging.l;
    }

    public final void log(String class_name,
            String message,
            Status status) {

        switch (status) {
            case Status.LOG:
                System.out.println(class_name + " : " + message);
                break;

            case Status.ERROR:
                System.err.println(class_name + " : " + message);
                System.exit(-1);
        }

    }

}