
import java.util.List;
import java.util.UUID;

class TrenDemo {

    List<Vagon> vagoaneList;
    final static int maximVagoane = 15;

//    static int nrElevi
//    Elev elev = new Elev()
//    elev.nrElevi
//    Elev.nrEelvi

    public void adaugareVagon(Vagon vagon) {
        vagoaneList.add(vagon);
        System.out.println("Vagonul a fost adaugat");
    }

    public void arataVagoanele() {
        for (int i = 0; i < vagoaneList.size(); i++) {
            System.out.println(vagoaneList.get(i));
//            a[i]
        }
    }

}

abstract class Vagoane {

}

class VagoaneA extends Vagoane {
    int pasageri = 40;
    int coletePostale = 300;

    public void deschidereUsi() {
        System.out.println("Usile au fost deschise");
    }

    public void inchidereaUsi() {
        System.out.println("Usile au fost inchise");
    }

}

class VagoaneB extends  Vagoane {
    int pasageri = 40;
    int coletePostale = 300;


    public void bloacareGeamurilor() {
        System.out.println("Geamurile au fost blocate");
    }

    public void deschidereUsi() {
        System.out.println("Usile au fost deschise");
    }

    public void inchidereaUsi() {
        System.out.println("Usile au fost inchise");
    }

}

class Marfa extends Vagoane {
    int coletePostale = 400;
}


public class Demo {
    public static void main(String[] args) {

        Tren trenA = new Tren();
        VagoaneA vagonA = new VagoaneA();
        VagoaneB vagonB = new VagoaneB();




        Tren trenB = new Tren();
        Marfa marfaA = new Marfa();
        Marfa marfaB = new Marfa();



    }
}