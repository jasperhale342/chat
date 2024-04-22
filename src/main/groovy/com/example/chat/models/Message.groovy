
@Entity
@Table(name="messages")
class Message {
    
    @Id
    Integer Id
    
    @OneToMany
    User author

    String message

    Date createdAt

}