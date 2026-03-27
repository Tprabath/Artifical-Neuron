package lk.prabhath.neuron;

public class Main {

    static double threshold = 0.5;
    static Neuron[] neurons = {
            new Neuron(
                    new double[] {
                            Normalization.min_max_normalize(
                                    20,
                                    100,
                                    0), // exam
                            Normalization.min_max_normalize(
                                    1,
                                    10,
                                    0) // attendence
                    },
                    new double[] {
                            0.6, // exam weigth
                            0.1 // attendence weight
                    },

                    0,
                    ActivationFunction.Sigmoid),

    };

    public static void main(String[] args) {

        for (int i = 0; i < Main.neurons.length; i++) {
            double output = Main.neurons[i].activate();

            StringBuilder sb = new StringBuilder();
            sb.append("\nNeuron [" + i + "] is activating...");
            sb.append("\n\t - input");
            sb.append(Main.concat(Main.neurons[i].getInputs()));
            sb.append("\n\t - weights");
            sb.append(Main.concat(Main.neurons[i].getweights()));
            sb.append("\n\t - output : " + output);
            sb.append("\n\t - fire : " + (output >= Main.threshold));

            System.out.println(sb.toString());
        }

    }

    private static final String concat(double[] valus) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for (double d : valus) {
            sb.append("\n\t    [" + (++i) + "] " + d);
        }

        return sb.toString();
    }
}
