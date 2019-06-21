import io.reactivex.*;
import io.reactivex.disposables.Disposable;

 
public class RxJavaObservableExample {
	public static void main(String[] arg) {
		Observable<String> source = observableMethod1();
		Observable<String> source2 = obserevableMethod2();
		Observable<String> source3 = obserevableMethod3();
		Observer<String> observer = new Observer<String>() {

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("onComplete");
			}

			@Override
			public void onError(Throwable arg0) {
				// TODO Auto-generated method stub
				System.out.println("onError");	
			}

			@Override
			public void onNext(String arg0) {
				// TODO Auto-generated method stub
				System.out.println(arg0);
			}

 
			@Override
			public void onSubscribe(Disposable arg0) {
				// TODO Auto-generated method stub
				
			}
			
		};
		System.out.println("Observable intialization method 1:");
		source.subscribe(observer);
		System.out.println("Observable intialization method 2:");
		source2.subscribe(observer);
		System.out.println("Observable intialization method 3:");
		source3.subscribe(observer);
	}
	
	public static Observable<String> observableMethod1() {
		Observable<String> source = Observable.create(emitter->{
			try{
				emitter.onNext("Shahzad Afridi");
				emitter.onNext("Shahzad Ahmad");
				emitter.onNext("Shahzad khan");
				emitter.onNext("Shahzad jan");
				emitter.onComplete();
			}catch(Exception e) {
				emitter.onNext(e.getMessage());
				System.out.println(e.getMessage());
			}
		});
		return source;
		
	}
	
	public static Observable<String> obserevableMethod2() {
		Observable<String> observable = Observable.just("one", "two","three","four");
		return observable;
	}
	
	public static Observable<String> obserevableMethod3() {
		String arr[] = {"five", "six","seaven","eight"};
		Observable<String> observable = Observable.fromArray(arr);
		return observable;
	}
}
