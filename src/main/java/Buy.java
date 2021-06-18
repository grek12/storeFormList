import java.util.Arrays;

class Buy {
    private String Fam;
    private int kolPoc;
        private Buy nextBuy;
    int[] Pokupki = new int[10];

    public Buy(String aFam, Buy aNext) {
        Fam = aFam;
        nextBuy = aNext;
        kolPoc = 0;
    }

    public Buy getNext() {
        return nextBuy;

    }

    public void setNext(Buy aNext) {
        this.nextBuy = aNext;
    }

    public String getFam() {
        return Fam;
    }

    public void setFam(String NewFam) {
        Fam = NewFam;
    }

    public int getKolPoc() {
        return kolPoc;
    }

    public int getPocupka(int nom) {
        return Pokupki[nom];
    }

    public boolean setPocupka(int nom, int newPoc) {
        Pokupki[nom] = newPoc;
        return true;
    }

    public boolean addPocupka(int newPoc) {
        Pokupki[kolPoc] = newPoc;
        kolPoc++;
        return true;
    }

    public int sumPoc() {
        int sum = 0;
        for (int num : Pokupki) {
            sum = sum + num;
        }
        return sum;
    }

    public float SredBall() {
        int sum = 0;
        float SredBall;
        for (int num : Pokupki) {
            sum = sum + num;
        }
        SredBall = sum / kolPoc;
        return SredBall;
    }

    public String getData() {
        String PokupkiString = Arrays.toString(Pokupki);
        String text1;
        text1 = ("Фамилия покупателя: " + getFam() + "\n" +
                "Цены покупок покупателя: " + " \n " + PokupkiString + "\n" +
                "Сумма покупок: " + sumPoc()) + "\n"+"\n";
        return text1;
    }
}
