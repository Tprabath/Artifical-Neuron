enum ActivationFunction {
    Sigmoid,
    ReLU,
    Tanh
}

class Normalization{
    private final double min_max_normalize(double input, double max_value, double min_value) {
        return (input - min_value) / (max_value - min_value);
    }
}

public final class Neuron {
    double bias;
    double[] inputs, wights;

    public Neuron(
        double[] inputs,
        double[] wights){

            this.inputs = inputs;
            this.wights = wights;
    }

    public final double fire() {

         // 

        return 0;
    }

    private final double activationFunction(
            double value,
            ActivationFunction func) {

        switch (func) {
            case ActivationFunction.Sigmoid:
                return 1 / (1 + Math.exp(value));

            default:
                System.out.println("Futrure Impliment");
                return 0;
        }

    }

    public void setBias(double bias){
        this.bias = bias;
    }

}

class Main {

    double[] inputs;
    double[] wights;

    public static void main(String[] args) {

    }
}