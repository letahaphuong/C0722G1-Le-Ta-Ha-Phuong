import {Injectable} from '@angular/core';
import {addMonths, addYears, differenceInYears, differenceInMonths, differenceInDays} from 'date-fns';

@Injectable({
  providedIn: 'root'
})
export class DateUtilService {
  constructor() {
  }

  getDiffToNow(diff: string | number | Date): string {
    const result: string[] = [];
    const now = new Date();
    diff = new Date(diff);
    const years = differenceInYears(now, diff);
    console.log(years)
    // @ts-ignore
    if (years > 0) {
      result.push(`${years} years`);
      diff = addYears(diff, years)
      console.log('năm nè' + result)
    }
    const months = differenceInMonths(now, diff);
    result.push(`${months} months`);
    if (months > 0) {
      diff = addMonths(diff, months);
      console.log('tháng nè' + result)

    }

    const days = differenceInDays(now, diff);
    if (days > 0) {
      result.push(`${days} days`);
      console.log('ngày nè' + result)
    }

    return result.join(' ');
  }
}
