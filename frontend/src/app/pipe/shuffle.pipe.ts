import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'shuffle' })
export class ShufflePipe implements PipeTransform {
  transform(array: any[]): any[] {
    return [...array].sort(() => Math.random() - 0.5);
  }
}
