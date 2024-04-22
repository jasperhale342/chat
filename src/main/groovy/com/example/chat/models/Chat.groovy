
@Entity
@Table(name="chats")
class Chat {

    @Id
    Integer Id

    @ManyToMany
    Set<User> users

    @OneToMany
    Set<Messages> Messages



}