package entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author brend
 */
@Entity()
public class RedUsuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idRedSocial", nullable = false)
    private RedSocial redSocial;
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;
    @Column(name = "fechaRegistro", nullable = false)
    @Temporal (TemporalType.TIMESTAMP)
    private Calendar fechaRegistro;
    @Column(name = "username", nullable = false)
    private String username;

    public RedUsuario() {
    }

    public RedUsuario(RedSocial redSocial, Usuario usuario, Calendar fechaRegistro, String username) {
        this.redSocial = redSocial;
        this.usuario = usuario;
        this.fechaRegistro = fechaRegistro;
        this.username = username;
    }
    
}
