package com.desafiostoom.CRUD_Endereco.entity;

    import javax.persistence.Column;
    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;

    @Entity
public class Endereco {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
    
        @Column(nullable = false)
        private String streetName;

        @Column(nullable = false)
        private String number;

        @Column(nullable = true)
        private String complement;

        @Column(nullable = false)
        private String neighbourhood;
    
        @Column(nullable = false)
        private String city;

        @Column(nullable = false)
        private String state;

        @Column(nullable = false)
        private String country;

        @Column(nullable = false)
        private String zipcode;

        @Column(nullable = true)
        private String latitude;

        @Column(nullable = true)
        private String longitude;

    public String getStreetName() {
        return this.streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return this.complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighbourhood() {
        return this.neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

        public long getId() {
            return id;
        }
    
        public void setId(long id) {
            this.id = id;
        }
    }
