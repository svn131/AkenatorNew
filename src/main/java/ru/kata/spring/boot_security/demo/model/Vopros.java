package ru.kata.spring.boot_security.demo.model;


//@Entity
//@Table(name = "vopros")
public class Vopros implements Comparable<Vopros> {
    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String value;


    private int otvet;


    private int count1;

    private int countMinus1;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Vopros() {
    }

    public Vopros(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getOtvet() {
        return otvet;
    }

    public void setOtvet(int otvet) {
        this.otvet = otvet;
    }

    public Vopros(int otvet) {
        this.otvet = otvet;
    }


    public int getCount1() {
        return count1;
    }

    public void incremetCount1() {
        count1++;
    }

    public int getCountMinus1() {
        return countMinus1;
    }

    public void incremetCountNimus1() {
        countMinus1++;
    }

    public void nulableSet(){
        count1 = 0;
        countMinus1 = 0;
    }



    @Override
    public int compareTo(Vopros vo) {
        if (this.countMinus1 > this.count1 && vo.countMinus1 > vo.count1) {
            // Если оба объекта имеют countMinus1 > count1, сравниваем по count1
            return Integer.compare(this.count1, vo.count1);
        } else if (this.countMinus1 <= this.count1 && vo.countMinus1 <= vo.count1) {
            // Если оба объекта имеют countMinus1 <= count1, сравниваем по countMinus1
            return Integer.compare(this.countMinus1, vo.countMinus1);
        } else if (this.countMinus1 <= this.count1 && vo.count1 <= vo.countMinus1) {

            return Integer.compare(this.countMinus1, vo.count1);

        } else if ( this.count1 <= this.countMinus1  && vo.countMinus1  <=  vo.count1) {

            return Integer.compare(this.count1, vo.countMinus1);

        }

        return 0;
    }
}

