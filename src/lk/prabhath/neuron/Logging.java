package lk.prabhath.neuron;
public final class Logging{

    static enum Status {
        LOG,
        ERROR
    }

    private static Logging l;
    private static String pefix =" : \n - ";

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
                System.out.println("\n"+ class_name +pefix+ message);
                break;

            case Status.ERROR:
                System.err.println("\n"+ class_name + pefix+ message);
                System.exit(-1);
        }

    }

}