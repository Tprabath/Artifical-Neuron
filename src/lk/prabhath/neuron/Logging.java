package lk.prabhath.neuron;
public final class Logging{

    static enum Status {
        LOG,
        ERROR
    }

    private static Logging l;
    private static String prefix =" : \n - ";
    private static String c_name_prefix = "\n Class - ";

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
                System.out.println(c_name_prefix + class_name +prefix+ message);
                break;

            case Status.ERROR:
                System.err.println(c_name_prefix + class_name + prefix+ message);
                System.exit(-1);
        }

    }

}