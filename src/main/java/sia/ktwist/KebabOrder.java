package sia.ktwist;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class KebabOrder {
    private String deliveryName;
    private String deliveryStreet;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private List<Kebab> kebabList = new ArrayList<>();

    public void addKebab(Kebab kebab){
        this.kebabList.add(kebab);
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public String getDeliveryStreet() {
        return deliveryStreet;
    }

    public void setDeliveryStreet(String deliveryStreet) {
        this.deliveryStreet = deliveryStreet;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCcExpiration() {
        return ccExpiration;
    }

    public void setCcExpiration(String ccExpiration) {
        this.ccExpiration = ccExpiration;
    }

    public String getCcCVV() {
        return ccCVV;
    }

    public void setCcCVV(String ccCVV) {
        this.ccCVV = ccCVV;
    }

    public List<Kebab> getKebabList() {
        return kebabList;
    }

    public void setKebabList(List<Kebab> kebabList) {
        this.kebabList = kebabList;
    }


}
