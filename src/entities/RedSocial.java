package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author brend
 */
@Entity
@Table(name = "redesSociales")
public class RedSocial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "website")
    private String website;
    @Column(nullable = false, name = "fechaInicio")
    @Temporal (TemporalType.TIMESTAMP)
    private Calendar fechaInicio;
    @OneToMany(mappedBy = "redSocial", cascade = CascadeType.ALL)
    private List<RedUsuario> usuarios;
    
    public RedSocial(){
        this.usuarios = new ArrayList<>();
    }

    public RedSocial(String name, String website, Calendar fechaInicio) {
        this.name = name;
        this.website = website;
        this.fechaInicio = fechaInicio;
        this.usuarios = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public List<RedUsuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<RedUsuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.id != null ? this.id : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof RedSocial)) {
            return false;
        }
        RedSocial other = (RedSocial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RedSocial{" + id + '}';
    }
}
