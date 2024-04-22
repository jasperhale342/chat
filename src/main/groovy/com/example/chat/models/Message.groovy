
@Entity
@Table(name="messages")
class Message {
    
    @Id
    Integer Id
    
    User author

    String message

    Date createdAt

}