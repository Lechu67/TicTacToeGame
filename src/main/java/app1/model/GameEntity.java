package app1.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "game")
public class GameEntity {

    @Id
    @Column(name = "game_id")
    private Integer id;

    @Column(name = "symbol")
    private char userSymbol;

    @Column(name = "is_user_next_move")
    private boolean isUserNextMove;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private UserEntity user;

    @Column(name = "dimension")
    private int dimension;

    public GameEntity() {
    }

    public GameEntity(char userSymbol, boolean isUserNextMove, UserEntity user, int dimension) {
        this.userSymbol = userSymbol;
        this.isUserNextMove = isUserNextMove;
        this.user = user;
        this.dimension=dimension;
    }

    public boolean isUserNextMove() {
        return isUserNextMove;
    }

    public void setUserNextMove(boolean userNextMove) {
        isUserNextMove = userNextMove;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public char getUserSymbol() {
        return userSymbol;
    }

    public void setUserSymbol(char userSymbol) {
        this.userSymbol = userSymbol;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
