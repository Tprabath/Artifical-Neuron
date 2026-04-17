package lk.prabhath.neuron.ui;

public class Home {
    
    class home_window extends javax.swing.JFrame{
        public home_window(){
            this.init();
        }
        
        private void init(){
            this.setTitle("Artifical Neuron UI");
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setSize(
                500,
                500
            );

            this.setLocationRelativeTo(this);
            this.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Home()
            .new home_window();        
    }

}
