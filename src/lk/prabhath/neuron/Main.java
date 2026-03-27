package lk.prabhath.neuron;

public class Main {

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
