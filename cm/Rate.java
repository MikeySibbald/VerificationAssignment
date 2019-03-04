package cm;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CM on 01/02/2018.
 */
public class Rate {
    private CarParkKind kind;
    private BigDecimal hourlyNormalRate;
    private BigDecimal hourlyReducedRate;
    private ArrayList<Period> reduced = new ArrayList<>();
    private ArrayList<Period> normal = new ArrayList<>();

    public Rate(CarParkKind kind, BigDecimal normalRate, BigDecimal reducedRate, ArrayList<Period> reducedPeriods
            , ArrayList<Period> normalPeriods) {
        if (reducedPeriods == null || normalPeriods == null) {
            throw new IllegalArgumentException("periods cannot be null");
        }
        if (normalRate == null || reducedRate == null) {
            throw new IllegalArgumentException("The rates cannot be null");
        }
        if (normalRate.compareTo(BigDecimal.ZERO) < 0 || reducedRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("A rate cannot be negative");
        }
        if (normalRate.compareTo(reducedRate) <= 0) {
            throw new IllegalArgumentException("The normal rate cannot be less or equal to the reduced rate");
        }
        if (!isValidPeriods(reducedPeriods) || !isValidPeriods(normalPeriods)) {
            throw new IllegalArgumentException("The periods are not valid individually");
        }
        if (!isValidPeriods(reducedPeriods, normalPeriods)) {
            throw new IllegalArgumentException("The periods overlaps");
        }
        this.kind = kind;
        this.hourlyNormalRate = normalRate;
        this.hourlyReducedRate = reducedRate;
        this.reduced = reducedPeriods;
        this.normal = normalPeriods;
    }

    /**
     * Checks if two collections of periods are valid together
     * @param periods1
     * @param periods2
     * @return true if the two collections of periods are valid together
     */
    private boolean isValidPeriods(ArrayList<Period> periods1, ArrayList<Period> periods2) {
        Boolean isValid = true;
        int i = 0;
        while (i < periods1.size() && isValid) {
            isValid = isValidPeriod(periods1.get(i), periods2);
            i++;
        }
        return isValid;
    }

    /**
     * checks if a collection of periods is valid
     * @param list the collection of periods to check
     * @return true if the periods do not overlap
     */
    private Boolean isValidPeriods(ArrayList<Period> list) {
        Boolean isValid = true;
        if (list.size() >= 2) {
            Period secondPeriod;
            int i = 0;
            int lastIndex = list.size()-1;
            while (i < lastIndex && isValid) {
                isValid = isValidPeriod(list.get(i), ((List<Period>)list).subList(i + 1, lastIndex+1));
                i++;
            }
        }
        return isValid;
    }

    /**
     * checks if a period is a valid addition to a collection of periods
     * @param period the Period addition
     * @param list the collection of periods to check
     * @return true if the period does not overlap in the collection of periods
     */
    private Boolean isValidPeriod(Period period, List<Period> list) {
        Boolean isValid = true;
        int i = 0;
        while (i < list.size() && isValid) {
            isValid = !period.overlaps(list.get(i));
            i++;
        }
        return isValid;
    }
    public BigDecimal calculate(Period periodStay) {
        int normalRateHours = periodStay.occurences(normal);
        int reducedRateHours = periodStay.occurences(reduced);
        BigDecimal maxStaffPrice = new BigDecimal("16");
        BigDecimal minMgmtPay = new BigDecimal("3");
        BigDecimal visPay = new BigDecimal("8");
        BigDecimal halfPay = new BigDecimal(".5");
        BigDecimal free = new BigDecimal("0");
        BigDecimal studentPay = new BigDecimal("5.5");
        BigDecimal studentDisc = new BigDecimal(".25");
        BigDecimal studentReduced = new BigDecimal("0");
        BigDecimal price = this.hourlyNormalRate.multiply(BigDecimal.valueOf(normalRateHours)).add(
                this.hourlyReducedRate.multiply(BigDecimal.valueOf(reducedRateHours)));
        if(kind == CarParkKind.STAFF)
        {
        	if(price.compareTo(maxStaffPrice) == 1)
        	{
        		price = new BigDecimal("16");
        	}
        }
        else if(kind == CarParkKind.MANAGEMENT)
        {
        	if(price.compareTo(minMgmtPay) == -1);
        	{
        		price = minMgmtPay;
        	}
        }
        else if(kind == CarParkKind.VISITOR)
        {
        	if(price.compareTo(visPay) == 1 || price.compareTo(visPay) == 0)
        	{
        		price = (price.subtract(visPay)).multiply(halfPay);
        	}
        	else
        	{
        		price = free;
        	}
        }
        else if(kind == CarParkKind.STUDENT)
        {
        	if(price.compareTo(studentPay) == 1)
        	{
        		studentReduced = price.subtract(studentPay);
        		studentReduced = studentReduced.multiply(studentDisc);
        		price = price.add(studentReduced);
        	}
        }
        return price;
        
        
    }

}
