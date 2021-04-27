import java.security.SecureRandom;
import java.util.Random;

public class BaseballService {

    private String[] targetNumbers;
    private int numberSize;

    /**
     * 게임 시작.
     * @param size 숫자 야구 게임 숫자 길이.
     */
    public void startGame(int size) {
        if (size == 0) {
            size = Constants.BASEBALL_DEFAULT_NUMBER_SIZE;
        }

        this.numberSize = size;
        targetNumbers = this.createRandomNumbers(size);
    }

    /**
     * 야구 게임에 사용할 숫자 생성.
     * @param size 야구 게임에 사용할 숫자 사이즈.
     * @return 야구 게임에 사용할 숫자 객체.
     */
    public String[] createRandomNumbers(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(Message.LESS_THAN_1.getText());
        }

        Random random = new SecureRandom();
        String[] result = new String[size];

        for (int i = 0; i < size; i++) {
            result[i] = String.valueOf(random.nextInt(10));
        }

        return result;
    }

    /**
     * 야구 게임에 사용할 숫자 객체 반환.
     * @return 야구 게임에 사용할 숫자 객체.
     */
    public String[] getTargetNumbers() {
        return this.targetNumbers;
    }

    /**
     * 입력 받은 숫자들과 가지고 있는 숫자들과 비교.
     * @param input 입력 받은 숫자.
     */
    public void checkNumbers(String input) {
        if (!validate(input)) {
            return;
        }
    }

    /**
     * 사용자로 부터 입력 받은 숫자 검증.
     * @param input 사용자가 입력한 숫자.
     * @return 유효성 검사 결과값.
     */
    public boolean validate(String input) {
        // 값이 없다면.
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException(Message.NUMBER_REQUIRED.getText());
        }

        // 값이 허용 사이즈와 다르다면.
        if (input.length() != numberSize) {
            throw new IllegalArgumentException(
                Message.ONLY_LIMIT_CHARACTERS.getTextWithWord(String.valueOf(numberSize)));
        }

        return true;
    }    
}
