package company.innerclass;

public class Goods {
        private void internalTracking(boolean b) {
            if (b) {
                class TrackingSlip {
                    private String id;

                    TrackingSlip(String s) {
                        id = s;
                    }

                    String getSlip() {
                        return id;
                    }
                }
                TrackingSlip ts = new TrackingSlip("slip");
                String s = ts.getSlip();
            }
        }

        public void track() {
            internalTracking(true);
        }

        public static void main(String[] args) {
            Goods g = new Goods();
            g.track();
        }

}
