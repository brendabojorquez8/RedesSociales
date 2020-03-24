package entities;

import enums.Sexo;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author brend
 */
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "email")
    private String email;
    @Column(nullable = false, name = "fechaNacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaNacimiento;
    @Column(nullable = false, name = "sexo")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @Column(nullable = false, name = "edad")
    private int edad;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<RedUsuario> redesSociales;

    public Usuario() {
        this.redesSociales = new ArrayList<>();
    }

    public Usuario(String name, String email, Calendar birthDate, Sexo gender) {
        this.name = name;
        this.email = email;
        this.fechaNacimiento = birthDate;
        this.sexo = gender;
        this.redesSociales = new ArrayList<>();

        calcularEdad();
    }

    public void calcularEdad() {
        LocalDate now = LocalDate.now();

        LocalDate fNac = LocalDateTime.ofInstant(fechaNacimiento.toInstant(), 
                fechaNacimiento.getTimeZone().toZoneId()).toLocalDate();

        Period period = Period.between(fNac, now);

        this.edad = period.getYears();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getBirthDate() {
        return fechaNacimiento;
    }

    public void setBirthDate(Calendar birthDate) {
        this.fechaNacimiento = birthDate;
    }

    public Sexo getGender() {
        return sexo;
    }

    public void setGender(Sexo gender) {
        this.sexo = gender;
    }

    public int getAge() {
        return edad;
    }

    public void setAge(int age) {
        this.edad = age;
    }

    public List<RedUsuario> getRedesSociales() {
        return redesSociales;
    }

    public void setRedesSociales(List<RedUsuario> redesSociales) {
        this.redesSociales = redesSociales;
    }
    
    public void addRedSocial(RedUsuario red){
        this.redesSociales.add(red);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.id != null ? this.id : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + id + '}';
    }

}
