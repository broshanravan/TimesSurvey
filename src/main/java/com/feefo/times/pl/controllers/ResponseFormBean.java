package com.feefo.times.pl.controllers;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 07/06/13
 * Time: 10:38
 * To change this template use File | Settings | File Templates.
 */
public class ResponseFormBean {


     @NotEmpty
    private String overall_travel;

    @NotEmpty
    private String family_travel;

    @NotEmpty
    private String adventure_travel;

    @NotEmpty
    private String specialist_travel;

    @NotEmpty
    private String ski_company;

    @NotEmpty
    private String ocean_cruise;

    @NotEmpty
    private String river_cruise;

    @NotEmpty
    private String short_haul_airline;

    @NotEmpty
    private String long_haul_airline;

    @NotEmpty
    private String Uk_hotel;

    @NotEmpty
    private String european_hotel;

    @NotEmpty
    private String hotel_worldwide;

    @NotEmpty
    private String european_destination;

    @NotEmpty
    private String worldwide_destination;

    @NotEmpty
    private String Uk_city ;

    @NotEmpty
    private String overseas_city;

    @NotEmpty
    private String spa;

    @NotEmpty
    private String travel_booking_website;

    @NotEmpty
    private String Plus_three;



    public String getOverall_travel() {
        return overall_travel;
    }

    public void setOverall_travel(String overall_travel) {
        this.overall_travel = overall_travel;
    }

    public String getFamily_travel() {
        return family_travel;
    }

    public void setFamily_travel(String family_travel) {
        this.family_travel = family_travel;
    }

    public String getAdventure_travel() {
        return adventure_travel;
    }

    public void setAdventure_travel(String adventure_travel) {
        this.adventure_travel = adventure_travel;
    }

    public String getSpecialist_travel() {
        return specialist_travel;
    }

    public void setSpecialist_travel(String specialist_travel) {
        this.specialist_travel = specialist_travel;
    }

    public String getSki_company() {
        return ski_company;
    }

    public void setSki_company(String ski_company) {
        this.ski_company = ski_company;
    }

    public String getOcean_cruise() {
        return ocean_cruise;
    }

    public void setOcean_cruise(String ocean_cruise) {
        this.ocean_cruise = ocean_cruise;
    }

    public String getRiver_cruise() {
        return river_cruise;
    }

    public void setRiver_cruise(String river_cruise) {
        this.river_cruise = river_cruise;
    }

    public String getShort_haul_airline() {
        return short_haul_airline;
    }

    public void setShort_haul_airline(String short_haul_airline) {
        this.short_haul_airline = short_haul_airline;
    }

    public String getLong_haul_airline() {
        return long_haul_airline;
    }

    public void setLong_haul_airline(String long_haul_airline) {
        this.long_haul_airline = long_haul_airline;
    }

    public String getUk_hotel() {
        return Uk_hotel;
    }

    public void setUk_hotel(String uk_hotel) {
        Uk_hotel = uk_hotel;
    }

    public String getEuropean_hotel() {
        return european_hotel;
    }

    public void setEuropean_hotel(String european_hotel) {
        this.european_hotel = european_hotel;
    }

    public String getHotel_worldwide() {
        return hotel_worldwide;
    }

    public void setHotel_worldwide(String hotel_worldwide) {
        this.hotel_worldwide = hotel_worldwide;
    }

    public String getEuropean_destination() {
        return european_destination;
    }

    public void setEuropean_destination(String european_destination) {
        this.european_destination = european_destination;
    }

    public String getWorldwide_destination() {
        return worldwide_destination;
    }

    public void setWorldwide_destination(String worldwide_destination) {
        this.worldwide_destination = worldwide_destination;
    }

    public String getUk_city() {
        return Uk_city;
    }

    public void setUk_city(String uk_city) {
        Uk_city = uk_city;
    }

    public String getOverseas_city() {
        return overseas_city;
    }

    public void setOverseas_city(String overseas_city) {
        this.overseas_city = overseas_city;
    }

    public String getSpa() {
        return spa;
    }

    public void setSpa(String spa) {
        this.spa = spa;
    }

    public String getTravel_booking_website() {
        return travel_booking_website;
    }

    public void setTravel_booking_website(String travel_booking_website) {
        this.travel_booking_website = travel_booking_website;
    }

    public String getPlus_three() {
        return Plus_three;
    }

    public void setPlus_three(String plus_three) {
        Plus_three = plus_three;
    }


    /*
    private Map<String, Map<String, Map<String, String>>> responseMap;
    /

    public Map<String,  Map<String, Map<String, String>>> getResponseMap() {
        return responseMap;
    }

    public void setResponseMap(Map<String,  Map<String, Map<String, String>>> responseMapIn) {
        responseMap = responseMapIn;
    }
    */

}
