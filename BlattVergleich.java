package abgabe6;

import java.util.Comparator;

public class BlattVergleich implements Comparator<Blatt>
{

    @Override
    public int compare(Blatt o1, Blatt o2)
    {
        if(o1.isDrilling() && o2.isDrilling()) {
            if(o1.getDrillingValue() < o2.getDrillingValue()) {
                return -1;
            } else if (o1.getDrillingValue() == o2.getDrillingValue()) {
                return 0;
            } else {
                return 1;
            }
        } else if (o1.isZwilling() && o2.isZwilling()) {
            if(o1.getZwillingValue() < o2.getZwillingValue()) {
                return -1;
            } else if (o1.getZwillingValue() > o2.getZwillingValue()) {
                return 1;
            } else if (o1.getThirdCard() < o2.getThirdCard()) {
                return -1;
            } else if (o1.getThirdCard() > o2.getThirdCard()) {
                return 1;
            } else {
                return 0;
            }
        } else if (o1.isDrilling() && o2.isZwilling()) {
            return 1;            
        } else if (o1.isZwilling() && o2.isDrilling()) {
            return -1;
        } else if ((o1.isZwilling() || o1.isDrilling()) && !(o2.isZwilling() || o2.isDrilling())) {
            return 1;
        } else if (!(o1.isZwilling() || o1.isDrilling()) && (o2.isZwilling() || o2.isDrilling())) {
            return 1;
        } else {
            if (o1.getSum() < o2.getSum()) {
                return -1;
            } else if (o1.getSum() > o2.getSum()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
