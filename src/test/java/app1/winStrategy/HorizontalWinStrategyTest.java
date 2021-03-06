package app1.winStrategy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class HorizontalWinStrategyTest {

    @InjectMocks
    private HorizontalWinStrategy horizontalWinStrategy;

    @Test
    public void shouldReturnSymbol(){
        char[][] boardToTest= new char[2][2];
        boardToTest[1][0] = 'C';
        boardToTest[0][0] = 'C';
        assertThat(horizontalWinStrategy.isWin(boardToTest), is('C'));
    }
    @Test
    public void shouldReturnNull(){
        char[][] boardToTest= new char[2][2];
        boardToTest[0][1] = 'C';
        boardToTest[1][0] = 'C';
        assertNull(horizontalWinStrategy.isWin(boardToTest));
    }
}