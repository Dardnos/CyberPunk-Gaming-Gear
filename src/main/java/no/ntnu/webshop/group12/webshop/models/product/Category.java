package no.ntnu.webshop.group12.webshop.models.product;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "categories")
@Schema(description = "A category in the webshop", name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(unique = true, nullable = false, columnDefinition = "TEXT")
    private String name;

    private String image;
    private String imageWebp512;

    private String imageWebp1024;

    private String imageWebp2048;

    public Category() {
    }

    public Category(String name) {
        this(0, name, "");
    }

    public Category(String name, String image) {
        this(0, name, image);
    }

    public Category(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageWebp512() {
        return imageWebp512;
    }

    public String getImageWebp1024() {
        return imageWebp1024;
    }

    public String getImageWebp2048() {
        return imageWebp2048;
    }

    public void setImageAll(String name) {
        this.image = name + ".webp";
        this.imageWebp512 = name + "-512w.webp";
        this.imageWebp1024 = name + "-1024w.webp";
        this.imageWebp2048 = name + "-2048w.webp";
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((image == null) ? 0 : image.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Category other = (Category) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (image == null) {
            if (other.image != null)
                return false;
        } else if (!image.equals(other.image))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", image=" + image + "]";
    }
}
