import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/map';

@Injectable()
export class TmdbService {

  tmdbApi = 'https://api.themoviedb.org/3/search/person?api_key=cd250b00c7424ed2be7cf15a8d0d9332&language=en-US&query=';

  other = '&page=1&include_adult=false';
  tmdbImagePrefix = 'https://image.tmdb.org/t/p/original/';

  constructor(public http: HttpClient) {
  }

  get(searchTerm) {
    let searchString = searchTerm.replace(/\s/g, "%20");
    const apiLink = this.tmdbApi + searchString + this.other;
    return this.http.get(apiLink).map((response: any) => {
      console.log(response);
      if (response.results.length > 0) {
        //console.log(response.results[0].profile_path);
        return this.tmdbImagePrefix + response.results[0].profile_path;
      } else {
        return 'https://media.giphy.com/media/YaOxRsmrv9IeA/giphy.gif'; // dancing cat for 404
      }
    });
  }
}
