import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {DictionaryListComponent} from './dictionary/dictionary-page/dictionary-list.component';
import {DictionaryDetailComponent} from './dictionary/dictionary-detail/dictionary-detail.component';

const routes: Routes = [
  {
    path: 'dic',
    component: DictionaryListComponent
  }, {
    path: 'dic/detail/:word/:mean',
    component: DictionaryDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
