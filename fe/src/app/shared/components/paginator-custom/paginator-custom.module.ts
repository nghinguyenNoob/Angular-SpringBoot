import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { PaginatorCustomComponent } from './paginator-custom.component';
import { PaginationDirective } from './pagination.directive';
import { MatPaginatorModule } from '@angular/material/paginator';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

@NgModule({
  declarations: [PaginationDirective, PaginatorCustomComponent],
  imports: [
    // BrowserModule,
    MatPaginatorModule,
    MatFormFieldModule,
    // BrowserAnimationsModule,
  ],
  providers: [],
  exports: [PaginationDirective, PaginatorCustomComponent],
})
export class PaginatorCustomModule {}
