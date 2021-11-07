package be.condorcet.monprojet2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "local", schema = "public", catalog = "d6m1q13bi9o7ol")

public class Local {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sigle;
    private Integer places;
}
