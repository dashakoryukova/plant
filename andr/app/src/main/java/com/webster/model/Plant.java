package com.webster.model;

import java.sql.Date;
import java.util.List;

/**
 * Created by Admin on 16.03.2015.
 */
public class Plant {
    private String id;
    private String name;
    private String description;
    private List<PlantPhoto> plantPhotos;

    public Plant() {
    }

    public Plant(String id, String name, String description, List<PlantPhoto> plantPhotos) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.plantPhotos = plantPhotos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PlantPhoto> getPlantPhotos() {
        return plantPhotos;
    }

    public void setPlantPhotos(List<PlantPhoto> plantPhotos) {
        this.plantPhotos = plantPhotos;
    }

    private class PlantPhoto{
        private String id;
        private String path;
        private String description;
        private Date date;

        private PlantPhoto(String id, String description, String path, Date date) {
            this.id = id;
            this.description = description;
            this.path = path;
            this.date = date;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    };
}
