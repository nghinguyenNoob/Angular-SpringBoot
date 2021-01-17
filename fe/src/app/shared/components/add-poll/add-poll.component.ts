import { DatePipe } from '@angular/common';
import {
  Component,
  EventEmitter,
  Input,
  OnInit,
  Output
} from '@angular/core';
import { FormArray, FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { configButton } from '../../../store/models/button.i';
import { LabelInterface } from '../../../store/models/label.i';
import { Poll } from './poll';

@Component({
  selector: 'brc-add-poll',
  templateUrl: './add-poll.component.html',
  styleUrls: ['./add-poll.component.scss'],
})
export class AddPollComponent implements OnInit {

  public options: Array<FormGroup> = [];
  public formOption: FormGroup;
  public questionPoll: string = '';
  public dateExpiration: string = '';
  public timeExpiration: string = '';
  public checkMultipleAnswers: boolean = false;
  public optionCount: boolean = false;
  ///ad new
  // public optionForm: FormGroup;
  public numberOfPolls: number = 2;
  public submitted = false;
  public isQuestionRequired = true;
  public isTimeValid = true;
  public isDateValid = true;
  public isDateRequired = true;
  public isTimeRequired = true;

  constructor(private formBuilder: FormBuilder, private datePipe: DatePipe) { }
  // input
  @Input() buttonSubmit: configButton;
  @Input() labelQuestion: LabelInterface;
  @Input() labelExpiration: LabelInterface;
  @Input() labelOption: LabelInterface;
  @Input() allowMultipleAnswer: LabelInterface;
  // output
  @Output() getDay: EventEmitter<string> = new EventEmitter<string>();
  @Output() getHour = new EventEmitter<string>();
  @Output() getMinute = new EventEmitter<string>();
  @Output() pollFormData: EventEmitter<Poll> = new EventEmitter<Poll>();
  @Output() pollOptionFormData: EventEmitter<any> = new EventEmitter<any>();


  /////
  public pollParentForm: FormGroup;
  public pollChildFrom: FormGroup;
  public optionForm: FormGroup;

  ngOnInit() {
    this.optionForm = this.formBuilder.group({
      polls: new FormArray([])
    });
    for (let i = 0; i < this.numberOfPolls; i++) {
      this.option.push(
        this.formBuilder.group({
          optionName: ['', Validators.required],
        })
      );
    }
    // this.pollChildFrom = this.formBuilder.group({
    //   questionPoll: new FormControl('', Validators.required),
    //   dateExpiration: new FormControl('', Validators.required),
    //   timeExpiration: new FormControl('', Validators.required),
    //   allowMultipleAnswer: new FormControl(false)
    // });

    // this.pollParentForm = this.formBuilder.group({
    //   this.pollChildFrom,
    //   this.optionForm
    // })
  }

  // convenience getters for easy access to form fields
  get fOption() {
    return this.optionForm.controls;
  }
  get option() {
    return this.fOption.polls as FormArray;
  }

  //
  addOption() {
    this.numberOfPolls = this.numberOfPolls + 1;
    if (this.numberOfPolls > 2) {
      this.optionCount = true;
    }
    if (this.option.length < this.numberOfPolls) {
      for (let i = this.option.length; i < this.numberOfPolls; i++) {
        this.option.push(
          this.formBuilder.group({
            optionName: ["", Validators.required],
          })
        );
      }
    }
    this.submitted = false;
  }

  clearOption(index: number) {
    if (this.numberOfPolls > 2) {
      this.numberOfPolls = this.numberOfPolls - 1;
      this.option.removeAt(index);
      if (this.numberOfPolls <= 2) {
        this.optionCount = false;
      }
    }
  }

  saveDataPoll(data) {
    let question = data.question;
    let dayInput = data.date;
    let timeInput = data.time;
    let checkMultipleAnswers = data.checkMultipleAnswers;
    let isValidate = true;
    let hour: number  = 0;
    this.submitted = true;
    this.isQuestionRequired = true;
    this.isDateRequired = true;
    this.isTimeRequired = true;
    this.isDateValid = true;
    this.isTimeValid = true;

    // Validate question, date, time, checkMultiple

    let dateSystem = new Date();
    let daySystem = this.datePipe.transform(dateSystem, 'yyyy-MM-dd');
    let timeSystem = this.datePipe.transform(dateSystem, 'hh:mm a');
    let time = timeSystem.match(/([0-9])\d+/g);
    let hourStr = time[0];
    let minuteStr = time[1];
    let midday = timeSystem.match(/([A-Z])\w+/g);
    if(midday[0] == 'PM') {
      hour = Number(hourStr) + 12;
      timeSystem = hour + ':' +minuteStr;
    }

    if (question == '') {
      this.isQuestionRequired = false;
      isValidate = false;
      console.log("question blank")
    }
    if (dayInput == '') {
      this.isDateRequired = false;
      isValidate = false;
      console.log("day blank")
    } else {
      if (dayInput < daySystem) {
        this.isDateValid = false;
        isValidate = false;
        console.log("day notvalid")
      }
    }
    if (timeInput == '') {
      this.isTimeRequired = false;
      isValidate = false;
      console.log("time blank")
    } else {
      console.log(dayInput + " " +daySystem)
      console.log(timeInput +" " +timeSystem)
      if (dayInput == daySystem) {
        if (timeInput < timeSystem) {
          this.isTimeValid = false;
          isValidate = false;
          console.log("time notvalid")
        }
      }
    }

    // Validate option
    if (this.option.length > 0) {
      for (let op of this.option.value) {
        if (op.optionName == '') {
          isValidate = false;
          console.log("Option name blank")
        }
      }
    }

    if (!isValidate) {
      return
    }

    // Set data Poll send to page add
    let dataPoll: Poll = new Poll();
    dataPoll.question = question;
    dataPoll.date = dayInput;
    dataPoll.time = timeInput;
    dataPoll.checkMultipleAnswers = checkMultipleAnswers;
    dataPoll.optionPoll = this.option;
    this.pollFormData.emit(dataPoll);
    this.submitted = false;
  }
}
