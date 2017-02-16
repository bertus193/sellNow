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

			var imageView = FindViewById<ImageView>(Resource.Id.image1);
			imageView.SetImageResource(Resource.Drawable.lamparas);

			imageView.Click += (sender, e) =>
			{
				SetContentView(Resource.Layout.Producto);
				createMenu();
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

