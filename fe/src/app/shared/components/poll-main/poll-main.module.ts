import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from '../button/button.module';
import { DatePickerModule } from '../date-time-picker/date-picker/date-picker.module';
import { LabelModule } from '../label/label.module';
import { SelectModule } from '../select/select.module';
import { TextareaModule } from '../textarea/textarea.module';
import { PollMainComponent } from './poll-main.component';
import { SharedModule } from '../../shared.module';


@NgModule({
  declarations: [PollMainComponent],
  imports: [
    SharedModule,
    FormsModule,
    ButtonModule,
    DatePickerModule,
    LabelModule,
    SelectModule,
    CommonModule,
    TextareaModule
  ],
  exports: [PollMainComponent],
})
export class PollMainModule {}
