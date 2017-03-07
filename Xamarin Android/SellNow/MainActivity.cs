using System;
using Android.App;
using Android.Content;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using Android.OS;
using SellNowMenu;

namespace SellNow
{
    [Activity(Label = "SellNow", MainLauncher = true, Theme = "@android:style/Theme.Holo.NoActionBar")]
    public class Activity1 : Activity
	{
		protected override void OnCreate(Bundle bundle)
		{
			base.OnCreate(bundle);

			SetContentView(Resource.Layout.Main);

			createMenu();

			var itemLista = FindViewById<FrameLayout>(Resource.Id.item1);
			var imageView = FindViewById<ImageView>(Resource.Id.image1);
			imageView.SetImageResource(Resource.Drawable.lamparas);

			for (int i = 0; i < 5; i++)
			{
				imageView.SetImageResource(Resource.Drawable.lamparas);
			}

			itemLista.Click += (sender, e) =>
			{
				StartActivity(new Intent(this, typeof(verProducto)));
				//intent.PutStringArrayListExtra("phone_numbers", phoneNumbers);
			};

		}

		public void createMenu()
		{
			var menu = FindViewById<SellNowContainer>(Resource.Id.SellNowContainer);
			var menuButton = FindViewById(Resource.Id.MenuButton);
			menuButton.Click += (sender, e) =>
			{
				menu.AnimatedOpened = !menu.AnimatedOpened;
			};
		}
	}
}

