package app1.repository;

import app1.model.GameEntity;
import app1.model.Move;
import app1.model.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GameDAOImpl implements GameDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean isMovePossible(Move move) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Move where column=?1 and row=?2 and game=?3")
                .setParameter(1,move.getColumn())
                .setParameter(2,move.getRow())
                .setParameter(3,move.getGame())
                .list()
                .isEmpty();
    }
    @Override
    public List<Move> findMovesByGame(GameEntity gameEntity) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Move where game=?")
                .setParameter(0,gameEntity)
                .list();
    }
    @Override
    public void saveNewMove(Move move) {
        sessionFactory.getCurrentSession().save(move);
    }

    @Override
    public void updateGame(GameEntity gameEntity) {
        sessionFactory.getCurrentSession().update(gameEntity);
    }

    @Override
    public void saveNewGame(GameEntity gameEntity) {
        sessionFactory.getCurrentSession().save(gameEntity);
    }

    @Override
    public GameEntity findGameByUserName(UserEntity userEntity) {
        return (GameEntity) sessionFactory.getCurrentSession()
                .createQuery("from GameEntity where user=?")
                .setParameter(0,userEntity)
                .uniqueResult();
    }
    @Override
    public void removeGameAndMoves(GameEntity currentGameEntity) {
        sessionFactory.getCurrentSession()
                .createQuery("delete from Move where game=:game")
                .setParameter("game",currentGameEntity)
                .executeUpdate();
        sessionFactory.getCurrentSession().delete(currentGameEntity);
    }


}
