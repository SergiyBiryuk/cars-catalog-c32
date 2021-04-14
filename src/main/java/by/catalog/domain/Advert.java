package by.catalog.domain;

import by.catalog.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Advert implements Comparable<Advert>, Comparator<Advert> {

    private long id;
    private String markCar;
    private String modelCar;
    private String colorCar;
    private int yearCar;
    private double priceCar;
    private long idUser;
    private String dateAdvert;
    private String specificationAdvert;
    private List<Message> message;

    public Advert(long id, String markCar, String modelCar, String colorCar, int yearCar, double priceCar, long idUser) {
        this.id = id;
        this.markCar = markCar;
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.yearCar = yearCar;
        this.priceCar = priceCar;
        this.idUser = idUser;
    }

    public Advert(String markCar, String modelCar, String colorCar, int yearCar, double priceCar, long idUser, List<Message> message) {
        this.markCar = markCar;
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.yearCar = yearCar;
        this.priceCar = priceCar;
        this.idUser = idUser;
        this.message = message;
    }

    public Advert(String markCar, String modelCar, String colorCar, int yearCar, double priceCar, long idUser, String dateAdvert, String specificationAdvert) {
        this.markCar = markCar;
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.yearCar = yearCar;
        this.priceCar = priceCar;
        this.idUser = idUser;
        this.specificationAdvert = specificationAdvert;
        this.dateAdvert = dateAdvert;
    }


    @Override
    public String toString() {

        UserService userService = new UserService();
        return
                "Model car - " + modelCar + ", color car - " + colorCar + ", year car - " + yearCar + ", price car - " + priceCar;
    }

    @Override
    public int compareTo(Advert car) {
        return Double.compare(this.getPriceCar(), car.getPriceCar());
    }

    @Override
    public int compare(Advert car1, Advert car2) {
        return car1.getYearCar() - car2.getYearCar();
    }

}
