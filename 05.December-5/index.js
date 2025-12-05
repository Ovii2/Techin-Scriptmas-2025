import {DIGITS} from "./Digits.js";
import {MESSAGES} from "./Messages.js";

const display = document.getElementById('display');

const printNumbers = async (arr, index) => {
    const digitIndex = arr.length - 1 - index;
    return arr[digitIndex].join('\n');
}

const printMessages = async (messages, index) => {
    return messages[index].join('\n');
}

const displayNumbersAndMessages = async (digits, messages) => {
    const length = Math.min(digits.length, messages.length);

    for (let i = 0; i < length; i++) {
        const numberBlock = await printNumbers(digits, i);
        const messageBlock = await printMessages(messages, i);
        display.textContent = numberBlock + '\n\n' + messageBlock;
        await new Promise(resolve => setTimeout(resolve, 1000));
    }
}

displayNumbersAndMessages(DIGITS, MESSAGES);
