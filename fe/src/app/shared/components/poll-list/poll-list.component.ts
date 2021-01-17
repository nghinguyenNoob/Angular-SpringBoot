import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { configButton } from '../../../store/models/button.i';
import { Category } from '../../../store/models/category.i';
import { Column, SortItem } from '../../../store/models/column.i';
import { LabelInterface } from '../../../store/models/label.i';
import { LabelledValue } from '../../../store/models/labelvalue.i';
import { ButtonFilterSchedule, FilterSchedule, LabelFilterSchedule, PlaceholderFilterSchedule } from '../../../store/models/schedule-filter.i';
import { ScheduleList } from '../../../store/models/scheduleList.i';

@Component({
  selector: 'brc-poll-list',
  templateUrl: './poll-list.component.html',
  styleUrls: ['./poll-list.component.scss'],
})
export class ScheduleListComponent implements OnInit {
  constructor() { }
  ngOnInit(): void { }

  //Input filter
  @Input() buttonFilterSchedule: ButtonFilterSchedule<configButton>;
  @Input() labelScheduleFilter: LabelFilterSchedule<LabelInterface>;
  @Input() placeholderFilterSchedule: PlaceholderFilterSchedule = {
    placeholderSearch: 'search schedule...',
    titleImportance: 'Importance',
    titleCategory: 'Category',
  };
  @Input() scheduleDataCategory: Category[];
  @Input() scheduleDataImportance: LabelledValue<string>[];
  //Input table
  @Input() pollColumns: Column[] = [];
  @Input() pollDataSource: Object[] = [];
  @Input() votes: Object[] = [];
  @Input() scheduleShowRowSelection: boolean = false;
  //Input pagination
  @Input() scheduleTotalRecords: number = 0;
  @Input() scheduleRecordsPerPage: number = 0;
  @Input() schedulePageIndex: number = 0;
  //Input todolist
  @Input() configPollList: ScheduleList = {
    filterBox: 'Filter Box',
    title: 'Poll List',
    btnAdd: 'Add Poll',
  };

  //Input search
  @Input() searchText: string = '';
  @Input() placeholder: string = '';

  //Output filter
  @Output() valueFilter = new EventEmitter();
  //Output table
  @Output() rowClicked = new EventEmitter<Object>();
  @Output() rowsSelected = new EventEmitter<Object>();
  @Output() sort = new EventEmitter<SortItem[]>();

  //Out put schedulelist
  @Output() btnAddPoll: EventEmitter<string> = new EventEmitter<string>();
  @Output() rowDetail = new EventEmitter<Object>();
  @Output() rowDelete = new EventEmitter<Object>();
  @Output() pageOnPageChange: EventEmitter<number> = new EventEmitter<number>();
  @Output() onChangeSearch: EventEmitter<string> = new EventEmitter<string>();
  scheduleValueFilter(data: FilterSchedule) {
    this.valueFilter.emit(data);
  }
  handlerClickRow(data: Object) {
    this.rowClicked.emit(data);
  }
  handlerSort(data: SortItem[]) {
    this.sort.emit(data);
  }
  handlerSelectRow(data: Object) {
    this.rowsSelected.emit(data);
  }
  onClickBtnAdd() {
    this.btnAddPoll.emit();
  }
  onPageEvent(data: number) {
    this.pageOnPageChange.emit(data);
  }
  rowDetailEvent(data: Object) {
    this.rowDetail.emit(data);
  }
  rowDeleteEvent(data: Object) {
    this.rowDelete.emit(data);
  }
  onChangeSearchEvent(data: string) {
    this.onChangeSearch.emit(data);
  }
}
