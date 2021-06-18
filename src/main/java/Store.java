public class Store {
    private Buy firstBuy;
    private String StoreName;
    int buyCount;

    public Store(String aName) {
        StoreName = aName;
    }

    public Buy getFirstBuy() {
        return firstBuy;
    }

    public void addBuy(String aFam) {
        firstBuy = new Buy(aFam, firstBuy);
        buyCount++;

    }

    public boolean delBuy() {
            Buy t = firstBuy;
            if (t != null) {
                firstBuy = firstBuy.getNext();
                buyCount--;
            }
        return true;
    }

    public Buy findBuy(String aFam) {
        Buy currentBuy = firstBuy;

        while (currentBuy != null) {
            if (currentBuy.getFam().equals(aFam)) {

                return currentBuy;

            } else {
                currentBuy = currentBuy.getNext();
            }
        }
        return null;
    }

    public String getAllData() {
        Buy t = firstBuy;
        String text12 = " ";
        while (t != null) {
            text12 = t.getData() + text12;
            t = t.getNext();
        }
        return text12;
    }

            public float srCena() {
                Buy t = firstBuy;
                float obchBal = 0;
                float srBal = 0;
                while (t != null) {
                    obchBal = t.SredBall() + obchBal;
                    t = t.getNext();
                    srBal = obchBal / buyCount;
                }
                return srBal;
            }


}