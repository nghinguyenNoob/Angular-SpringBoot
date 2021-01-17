import { FormArray } from "@angular/forms";

export class Poll{
    question: string;
    date: string;
    time: string;
    checkMultipleAnswers: boolean;
    optionPoll: FormArray;
}

export class Status{
    public static IN_PROCESS = "In process";
}