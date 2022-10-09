package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenInvalidInputNegativeNumber() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }

    @Test
    public void whenInvalidInputRight() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "5", "4"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int first = input.askInt("Enter menu:");
        assertThat(first).isEqualTo(0);
        int second = input.askInt("Enter menu:");
        assertThat(second).isEqualTo(5);
        int third = input.askInt("Enter menu:");
        assertThat(third).isEqualTo(4);
    }
}
