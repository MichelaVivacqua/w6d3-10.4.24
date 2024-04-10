package michelavivacqua.w6d31044.entities;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Autore {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;
}
//public void setAvatar() {
//    this.avatar = "https://ui-avatars.com/api/?name=" + this.name + "+" + this.surname;
//}