package by.catalog.service;

import by.catalog.domain.Advert;
import by.catalog.storage.AdvertStorage;

import java.text.SimpleDateFormat;
import java.util.*;

public class AdvertService {

    private final AdvertStorage advertStorage = new AdvertStorage();

    public void saveAdvert(String mark, String model, String color, int year, double price, long idUser, String specificationAdvert) {
        AdvertStorage advertStorage = new AdvertStorage();
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E dd.MM.yyyy ' время' hh:mm");
        String date = formatForDateNow.format(dateNow);
        advertStorage.addAdvert(new Advert(mark, model, color, year, price, idUser, date, specificationAdvert));
    }


    public Advert getAdvert(long idAdvert) {
        return advertStorage.returnAdvertById(idAdvert);
    }

    public Advert getAdvertByIdAdvertAndIdUser(long idAdvert, long idUser){
        return advertStorage.returnAdvertByIdAdvertAndIdUser(idAdvert, idUser);
    }


    public void saveAdvertToUserAdvertList(long idAdvert, long idUser) {
        advertStorage.addIdUserIdAdvert(idUser, idAdvert);
        // FIXME: 6/13/20
    }

    public List<Advert> findAllInterestingAdverts(long idUser) {
        List<Advert> list = new ArrayList<>();
        List allIdAdvertByIdUser = advertStorage.getAllIdAdvertByIdUser(idUser);
        for (int i = 0; i < allIdAdvertByIdUser.size(); i++) {
            long idAdvert = (long) allIdAdvertByIdUser.get(i);
            Advert advert = advertStorage.returnAdvertById(idAdvert);
            list.add(advert);
        }
        return list;
    }

//    public List<Advert> findAllAdverts() {
////        return advertStorage.findAllAdverts();
//        // FIXME: 6/13/20
//        return null;
//    }

    public List<Advert> getLastAdvertsByColor(String color) {
        List<Advert> list = new ArrayList<>();
        List allAdverts = advertStorage.getAllAdverts();
        if (allAdverts != null) {
            for (int i = allAdverts.size() - 1; i > allAdverts.size() - 20 && i > -1; i--) {
                Advert advert = (Advert) allAdverts.get(i);
                if (color.equals("anyColor")) {
                    list.add(advert);
                } else if (advert.getColorCar().equals(color)) {
                    list.add(advert);
                }
            }
        }
        return list;
    }

    public List<Advert> getLastAdverts() {
        List<Advert> list = new ArrayList<>();
        List allAdverts = advertStorage.getAllAdverts();
        if (allAdverts != null) {
            for (int i = allAdverts.size() - 1; i > allAdverts.size() - 20 && i > -1; i--) {
                Advert advert = (Advert) allAdverts.get(i);
                list.add(advert);
            }
        }
        return list;
    }

    public Advert findAdvertById(long advertId) {
//        advertStorage.findAdvertById(advertId);
        // FIXME: 6/13/20
        return null;
    }

    public List<Advert> findAdvertByMark(String mark, String color) {
        List<Advert> listBySearch = new ArrayList<>();
        List allAdverts = advertStorage.getAllAdverts();
        for (int i = 0; i < allAdverts.size(); i++) {
            Advert advert = (Advert) allAdverts.get(i);
            if (advert.getMarkCar().equals(mark)) {
                if (color.equals("anyColor")) {
                    listBySearch.add(advert);
                } else if (advert.getColorCar().equals(color)) {
                    listBySearch.add(advert);
                }
            }
        }
        return listBySearch;
    }

    public List<Advert> findAdvertByModel(String mark, String model, String color) {
        List<Advert> listBySearch = new ArrayList<>();
        List markAdverts = findAdvertByMark(mark, color);
        for (Object markAdvert : markAdverts) {
            Advert advert = (Advert) markAdvert;
            if (advert.getModelCar().equals(model)) {
                listBySearch.add(advert);
            }
        }
        return listBySearch;
    }

    public List<String> getAdvertMarks() {
        return advertStorage.getAllAdvertMark();
    }

    public List<String> returnModelByMark(String mark) {
        return advertStorage.getModelByMark(mark);
    }

    public List<String> returnMarkByModel(String model) {
        return advertStorage.getMarkByModel(model);
    }

    public List<String> returnSortMark() {
        List<String> listMark = new ArrayList<>();
        boolean b = true;
        List<String> allMark = advertStorage.getAllMark();
        for (String mark : allMark) {
            for (String mark1 : listMark) {
                b = true;
                if (mark.equals(mark1)) {
                    b = false;
                    break;
                }
            }
            if (b) {
                listMark.add(mark);
            }
        }
        return listMark;
    }


    public List<String> returnSortModel() {
        List<String> listModel = new ArrayList<>();
        boolean b = true;
        List<String> allModel = advertStorage.getAllModel();
        for (String mark : allModel) {
            for (String mark1 : listModel) {
                b = true;
                if (mark.equals(mark1)) {
                    b = false;
                    break;
                }
            }
            if (b) {
                listModel.add(mark);
            }
        }
        return listModel;
    }


    public List<Advert> sortAllAdvertListByPrice(String sort, String color) {
        List<Advert> toSortList = getLastAdvertsByColor(color);
        toSortList.sort(Advert::compareTo);
        if (sort.equalsIgnoreCase("descPrice")) {
            Collections.reverse(toSortList);
        }
        return toSortList;
    }

    public List<Advert> sortAllAdvertListByYear(String sort, String color) {
        List<Advert> toSortList = getLastAdvertsByColor(color);
        toSortList.sort(new Advert());
        if (sort.equalsIgnoreCase("descYear")) {
            Collections.reverse(toSortList);
        }
        return toSortList;
    }

    public List<Advert> sortMarkAdvertListByPrice(String sort, String mark, String color) {
        List<Advert> toSortList = findAdvertByMark(mark, color);
        toSortList.sort(Advert::compareTo);
        if (sort.equalsIgnoreCase("descPrice")) {
            Collections.reverse(toSortList);
        }
        return toSortList;
    }

    public List<Advert> sortMarkAdvertListByYear(String sort, String mark, String color) {
        List<Advert> toSortList = findAdvertByMark(mark, color);
        toSortList.sort(new Advert());
        if (sort.equalsIgnoreCase("descYear")) {
            Collections.reverse(toSortList);
        }
        return toSortList;
    }

    public List<Advert> sortModelAdvertListByPrice(String sort, String mark, String model, String color) {
        List<Advert> toSortList = findAdvertByModel(mark, model, color);
        toSortList.sort(Advert::compareTo);
        if (sort.equalsIgnoreCase("descPrice")) {
            Collections.reverse(toSortList);
        }
        return toSortList;
    }

    public List<Advert> sortModelAdvertListByYear(String sort, String mark, String model, String color) {
        List<Advert> toSortList = findAdvertByModel(mark, model, color);
        toSortList.sort(new Advert());
        if (sort.equalsIgnoreCase("descYear")) {
            Collections.reverse(toSortList);
        }
        return toSortList;
    }


    public List<Integer> listYear() {
        List<Integer> listYear = new ArrayList<>();
        for (int i = 1980; i < 2021; i++) {
            listYear.add(i);
        }
        return listYear;
    }

    public String[] colorList() {
        return new String[]{"black", "white", "silver", "brown", "gray", "red", "blue"};
    }

    public void removeInterestingAdvert(long idAdvert, long idUser) {
        advertStorage.removeIdAdvertIdUser(idAdvert, idUser);
    }

    public boolean checkIntrAdvert(long idAdvert, long idUser) {
        return advertStorage.checkIdUserIdAdvert(idUser, idAdvert);
    }

    public boolean checkAdvertByUser(long idAdvert, long idUser) {
        Advert advert = advertStorage.returnAdvertById(idAdvert);
        return advert.getIdUser() == idUser;
    }

    public void destroyAdvertByIdAdvert(long idAdvert, long idUser) {
        advertStorage.removeAdvertByIdAdvert(idAdvert, idUser);
    }

    public void destroyUserAdvertList (long idAdvert){
        advertStorage.removeAfterDestroyUserAdvertList(idAdvert);
    }

    public List<Advert> getAllUserAdvert(long idUser) {
        return advertStorage.getAllAdvertByIdUser(idUser);
    }

    public void editAdvertMarkAndModelByIdAdvert(long idAdvert, long idUser, String mark, String model){
        advertStorage.updateMarkAndModelById(idAdvert,idUser, mark, model);
    }
    public void editColorByIdAdvert(long idAdvert, long idUser, String color){
        advertStorage.updateColorById(idAdvert, idUser, color);
    }

    public void editYearByIdAdvert(long idAdvert, long idUser,int year){
        advertStorage.updateYearById(idAdvert, idUser, year);
    }

    public void editPriceByIdAdvert(long idAdvert,long idUser, double price){
        advertStorage.updatePriceById(idAdvert, idUser, price);
    }

    public void editSpecificationByIdAdvert(long idAdvert,long idUser, String specification){
        advertStorage.updateSpecificationById(idAdvert,idUser, specification);
    }
}


