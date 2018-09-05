import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class StarService {

  public API = '//localhost:8080';
  public STAR_API = this.API + '/stars';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(this.STAR_API);
  }

  get(id: string) {
    return this.http.get(this.STAR_API + '/' + id);
  }

  save(star: any): Observable<any> {
    let result: Observable<Object>;
    if (star['href']) {
      result = this.http.put(star.href, star);
    } else {
      result = this.http.post(this.STAR_API, star);
    }
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }

}

