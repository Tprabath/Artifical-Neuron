final class Logging{

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

enum ActivationFunction {
    Sigmoid,
    ReLU,
    Tanh
}

final class Normalization {
    private static final String c_name = "Normalization";

    public static final double min_max_normalize(double input, double max_value, double min_value) {
        if (input > max_value) {
            Logging
                .getInstance()
                .log(Normalization.c_name,
                        "Value must lass than max_value",
                        Logging.Status.ERROR);
        }

        return (input - min_value) / (max_value - min_value);
    }
}

public final class Neuron {
    private static final String c_name = "Neuron";

    double bias = 0d; // default 0
    double[] inputs, weights;
    ActivationFunction activationFunction;

    public Neuron(
            double[] inputs,
            double[] weights,
            ActivationFunction activationFunction) {

        this.inputs = this.checkpoint(inputs);
        this.weights = this.checkpoint(weights);
        this.activationFunction = activationFunction;
    }

    public final double fire() {
        double final_value = 0d;
        int values_length;

        // calculate sigma(wi*xi)
        if (inputs.length != weights.length) {
             Logging
                .getInstance()
                .log(Neuron.c_name,
                        "inputs length must equal to weights length",
                        Logging.Status.ERROR);
        }

        values_length = (inputs.length + weights.length) / 2;

        for (int i = 0; i < values_length; i++) {
            final_value = inputs[i] * weights[i];
        }

        return this.activationFunction(
                (final_value + this.bias), // add bias inline
                activationFunction);
    }

    private final double activationFunction(
            double value,
            ActivationFunction func) {

        switch (func) {
            case ActivationFunction.Sigmoid:
                return 1 / (1 + Math.exp(value));

            default:
                System.err.println("Not impliment");
                return 0;
        }

    }

    // check all values lass that 1 and more than 0
    private double[] checkpoint(double[] d){
        for(double v: d){
            if(v > 0 && 1 > v){

            }
        }

        return d;
    }   

    public void setBias(double bias) {
        this.bias = bias;
    }

    public double[] getInputs() {
        return this.inputs;
    }

    public double[] getweights() {
        return this.weights;
    }

}

class Main {

    static double threshold = 0.5;
    static Neuron[] neurons = {
            new Neuron(
                    new double[] {
                            Normalization.min_max_normalize(
                                    10,
                                    10,
                                    0), // exam
                            Normalization.min_max_normalize(
                                    20,
                                    10,
                                    0) // attendence
                    },
                    new double[] {
                            0.8, // exam weigths
                            0.2 // attendence weights
                    },
                    ActivationFunction.Sigmoid),

    };

    public static void main(String[] args) {

        for (int i = 0; i < Main.neurons.length; i++) {
            Main.neurons[i].setBias(-0.042);
            double output = Main.neurons[i].fire();

            StringBuilder sb = new StringBuilder();
            sb.append("\nNeuron [" + i + "] is firing...");
            sb.append("\n\t - input");
            sb.append(Main.concat(Main.neurons[i].getInputs()));
            sb.append("\n\t - weights");
            sb.append(Main.concat(Main.neurons[i].getweights()));
            sb.append("\n\t - output : " + output);
            sb.append("\n\t - pass or fail : " + (output >= Main.threshold ? "pass" : "fail"));

            System.out.println(sb.toString());
        }

    }

    private static String concat(double[] valus) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for (double d : valus) {
            sb.append("\n\t    [" + (++i) + "] " + d);
        }

        return sb.toString();
    }
}