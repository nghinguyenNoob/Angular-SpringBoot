import { Employee } from './employee';

export class ResponseEmployee {

    employees: Employee[];
    totalPages: number;
    pageNumbers: number;
    pageSize: number;
}
