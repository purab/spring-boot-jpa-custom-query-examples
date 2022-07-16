package in.purabtech.customquery.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tutorials")
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;

    private int level;
    private boolean published;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Tutorial() {
    }

    public Tutorial(String title, String description, int level, boolean published, Date createdAt) {
        this.title = title;
        this.description = description;
        this.level = level;
        this.published = published;
        this.createdAt = createdAt;
    }

    // getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
