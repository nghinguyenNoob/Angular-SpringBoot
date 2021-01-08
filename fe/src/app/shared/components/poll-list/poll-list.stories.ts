import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { action } from '@storybook/addon-actions';
import { storiesOf } from '@storybook/angular';
import { configButton } from '../../../store/models/button.i';
import { Category } from '../../../store/models/category.i';
import { Column } from '../../../store/models/column.i';
import { LabelInterface } from '../../../store/models/label.i';
import { LabelledValue } from '../../../store/models/labelvalue.i';
import { ButtonFilterSchedule, LabelFilterSchedule, PlaceholderFilterSchedule } from '../../../store/models/schedule-filter.i';
import { ScheduleListComponent } from './poll-list.component';
import { ScheduleListModule } from './poll-list.module';

storiesOf('Ga List', module)
    .add('Ga Component', () => ({
        component: ScheduleListComponent,
        moduleMetadata: {
            imports: [
                ScheduleListModule,BrowserAnimationsModule
            ],
          },
        props: {
            //Input
            scheduleColumns: columns,
            scheduleDataSource: dataSource,
            votes: vote,
            scheduleTotalRecords: 100,
            scheduleRecordsPerPage: 5,
            scheduleShowRowSelection: false,
            scheduleDataImportance: dataImportance,
            scheduleDataCategory: fakeData,
            buttonFilterSchedule: buttonFilterSchedule,
            labelScheduleFilter: labelScheduleFilter,
            placeholderFilterSchedule: placeholderFilterSchedule,
            valueFilter: action('filter'),
            //OutPut
            btnAddSchedule: action('btn add'),
            onPageChange: action('page changes'),
            rowClicked: action('handlerClickRow'),
            sort: action('handlersort'),
            rowsSelected: action('handleselectrow'),
        },

    }));

// mock data
const columns: Column[] = [
    {
        title: 'STT',
        dataIndex: 'stt',
        sort: true,
    },
    {
        title: 'Question',
        dataIndex: 'question',
        sort: true,
    },
    {
        title: 'Expriration',
        dataIndex: 'expriration',
        sort: true,
    },
    {
        title: 'Status',
        dataIndex: '',
    },
    {
        title: 'Created by',
        dataIndex: 'createdby',
        sort: true,
    },
];

const vote = [
  {id: 1, name:'Đi nhậu'},
  {id: 2, name:'Đi dạo phố'},
  {id: 3, name:'Đi shopping'},
]

const dataSource = [
  { id: 1, stt: '1', question: 'Giải đấu Liên Quân', expriration: '31/12/2020 17:30', status: 'In process', createdby: 'Phuong Dung'},
  { id: 2, stt: '2', question: 'Cuối tuần bạn muốn đi đâu?', expriration: '25/12/2020 11:30',  status: 'In process', createdby: 'Thach monus'},
  { id: 3, stt: '3', question: 'Tiệc Noel ăn gì?', expriration: '18/12/2020 17:30', status: 'In process', createdby: 'nc_nghi'},
  { id: 4, stt: '4', question: 'Teambuilding', expriration: '31/11/2020 17:30', status: 'Expired', createdby: 'Phuong Dung'},
  { id: 5, stt: '5', question: 'Mùa hè sôi động', expriration: '25/5/2020 17:30', status: 'Expired', createdby: 'Phuong Dung'},
];

//filter
const placeholderFilterSchedule: PlaceholderFilterSchedule = {
  placeholderSearch: 'search schedule...',
  titleImportance: 'importance',
  titleCategory: 'category',
};

const labelScheduleFilter: LabelFilterSchedule<LabelInterface> = {
  labelImportance: {
    content: 'Importance',
    size: 17,
    color: '',
    backgroundColor: '',
  },
  labelFromDate: {
    content: 'From date',
    size: 17,
    color: '',
    backgroundColor: '',
  },
  labelToDate: {
    content: 'To date',
    size: 17,
    color: '',
    backgroundColor: '',
  },
  labelCategory: {
    content: 'Category',
    size: 17,
    color: '',
    backgroundColor: '',
  },
};

const buttonFilterSchedule: ButtonFilterSchedule<configButton> = {
  buttonSubmit: {
    colorButton: 'primary',
    colorMouseOver: 'primary',
    colorMouseOut: 'primary',
    type: 'submit',
    text: 'Filter',
  },
  buttonReset: {
    colorButton: 'basic',
    colorMouseOver: 'basic',
    colorMouseOut: 'basic',
    type: 'reset',
    text: 'Clear',
  },
};

const dataImportance: LabelledValue<string>[] = [
  {
    label: 'high',
    value: '1',
  },
  {
    label: 'medium',
    value: '2',
  },
  {
    label: 'low',
    value: '3',
  },
];

const fakeData: Category[] = [
  { categoryName: 'Python', categoryId: 1 },
  { categoryName: 'React', categoryId: 2 },
  { categoryName: 'PHP', categoryId: 3 },
  { categoryName: 'Laravel', categoryId: 4 },
  { categoryName: 'NestJS', categoryId: 5 },
  { categoryName: 'Spring Boot', categoryId: 6 },
  { categoryName: 'Java', categoryId: 7 },
  { categoryName: 'Ruby', categoryId: 8 },
];
