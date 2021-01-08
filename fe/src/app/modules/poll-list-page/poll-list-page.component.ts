import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Column, SortItem } from '../../store/models/column.i';
import { PollRecord } from '../../store/models/pollList';
import { PollList } from '../../store/models/pollList.i';
import {
  FilterSchedule
} from '../../store/models/schedule.i';
import { PollService } from '../../store/services/poll.service';
import { StoreFacade } from '../../store/store-facades/schedule.store-facade';


@Component({
  selector: 'brc-poll-list-page',
  templateUrl: './poll-list-page.component.html',
  styleUrls: ['./poll-list-page.component.scss'],
})
export class PollListPageComponent implements OnInit {
  private filter: FilterSchedule = this.storeFacade.filter;
  public pollTotalRecords: number = 0;
  public pollRecordsPerPage: number = 5;
  public pollPageIndex: number = 0;
  public pollShowRowSelection: boolean = false;
  public pollColumns: Column[] = columns;
  public pollDataSource = [];
  public optionPollData = [];
  public optionPollDetailData = [];
  public topVotesData = [];
  public pollData = [];
  public pollList: PollRecord[];
  public votes = [];
  configPollList: PollList = {
    filterBox: 'Filter Box',
    title: 'Poll List',
    btnAdd: 'Add Poll',
  };
  constructor(private storeFacade: StoreFacade, private _router: Router, private pollservice: PollService) { }
  ngOnInit(): void {
    this.pollservice.getListPoll().subscribe(dataPoll => {
      this.pollData = dataPoll;
      this.pollservice.getListTopVote().subscribe(dataTop => {
        this.topVotesData = dataTop;
        this.configData(this.pollData, this.topVotesData);
      })
    });
  }

  configData(pollData: any, topVotesData: any) {
    let index = 0;
    this.pollDataSource = [];
    pollData.forEach(poll => {
      let topvotes: any;
      topvotes = ['top'];
      topVotesData.forEach(topVote => {
        if (poll['pollId'] == topVote['pollId']) {
          let vote = { optionName: topVote['optionName'], voteCount: topVote['voteCount'] };
          topvotes.push(vote);
        }
      });
      let data =
      {
        id: poll['pollId'], stt: index + 1, question: poll['question'], expiration: poll['expiration'], status: poll['status'], create_by: poll['firstName'] + " " + poll['lastName'],
        topvotes,
        action: 'action'
      }
      this.pollDataSource.push(data);
      index = index + 1;
    });
    this.pollTotalRecords = this.pollDataSource.length;
  }

  getPage(pageNumber: number, pageSize: number, textSearch: string) {
    this.pollDataSource = [];
    this.pollservice.getPollPagination({ page: pageNumber, size: pageSize, text: textSearch })
      .subscribe((response) => {
        this.pollDataSource = response.polls;
        console.log(this.pollDataSource);
        this.pollTotalRecords = response.totalPages;
        this.pollRecordsPerPage = response.pageSize;
        this.pollPageIndex = response.pageNumbers;
      });
  }
  scheduleFilter(data: FilterSchedule) {
    this.filter = data;
    let pagination = Object.assign({}, this.storeFacade.pagination);
    pagination.page = 1;
    this.storeFacade.filterSchedule(pagination, this.filter);
  }

  pollSort(data: SortItem[]) {
    this.filter = {
      textSearch: this.filter.textSearch,
      category: this.filter.category,
      importance: this.filter.importance,
      fromDateList: this.filter.fromDateList,
      toDateList: this.filter.toDateList,
      sort: data,
    };
    let pagination = Object.assign({}, this.storeFacade.pagination);
    this.storeFacade.filterSchedule(pagination, this.filter);
  }

  pollAdd(data) {
    this._router.navigateByUrl('poll/add');
  }

  rowDetail(data: Object) {
    this._router.navigateByUrl(`poll/poll-vote/${data['id']}`);
  }

  rowDelete(data: Object) {
    if (confirm("Are you sure delete poll")) {
      this.pollservice.deletePoll(data['id']).subscribe(data => {
        console.log(data);
        this.pollservice.getListPoll().subscribe(dataPoll => {
          this.pollData = dataPoll;
          this.pollservice.getListTopVote().subscribe(dataTop => {
            this.topVotesData = dataTop;
            this.configData(this.pollData, this.topVotesData);
          })
        })
      },
        error => {
          console.log(error);
        }
      );
    }
  }


  changePage(data) {
    this.getPage(0,5,"");
  }
}
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
    title: 'Expiration',
    dataIndex: 'expiration',
    sort: true,
  },
  {
    title: 'Status',
    dataIndex: 'status',
    sort: true,
  },
  {
    title: 'Created by',
    dataIndex: 'create_by',
    sort: true,
  },
  {
    title: 'Top votes',
    dataIndex: 'topvotes',
    sort: false,
  },
  {
    title: 'Action',
    dataIndex: 'action',
    sort: false,
  },
];
