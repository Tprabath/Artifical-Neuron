enum ActivationFunction {
    Sigmoid,
    ReLU,
    Tanh
}

final class Normalization {
    private final double min_max_normalize(double input, double max_value, double min_value) {
        return (input - min_value) / (max_value - min_value);
    }
}

public final class Neuron {
    double bias = 0d; // default 0
    double[] inputs, wights;
    ActivationFunction activationFunction;

    public Neuron(
            double[] inputs,
            double[] wights,
            ActivationFunction activationFunction) {

        this.inputs = inputs;
        this.wights = wights;
        this.activationFunction = activationFunction;
    }

    public final double fire() {
        double final_value = 0d;
        int values_length;

        // calculate sigma(wi*xi)
        if (inputs.length != wights.length) {
            System.err.println("inputs data length must equal to wights length");
            return 0d;
        }

        values_length = (inputs.length + wights.length) / 2;

        for (int i = 0; i < values_length; i++) {
            final_value = inputs[i] * wights[i];
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

    public void setBias(double bias) {
        this.bias = bias;
    }

}

class Main {

    public static void main(String[] args) {
       Neuron[] neurons = {
            new Neuron(
                new double[]{1.0,1.0},
                new double[]{0.1,0.1},
                ActivationFunction.Sigmoid),

       };

       for(int i = 0; i < neurons.length; i++){
            neurons[i].setBias(1);
            double output = neurons[i].fire();

            System.out.println("Neuron ["+ i + "] is firing..."
            +"\n\toutput : "+ output
            + "\n\tpass or fail : " + (output >= 0.5 ? "pass" : "fail"));
       }

    }
}