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
    [Activity(Label = "SellNow", MainLauncher = true, Theme = "@android:style/Theme.Holo.Light.NoActionBar")]
    public class Activity1 : Activity
	{
		protected override void OnCreate(Bundle bundle)
		{
			base.OnCreate(bundle);

			// Set our view from the "main" layout resource
			SetContentView(Resource.Layout.Main);

			var menu = FindViewById<SellNowContainer>(Resource.Id.SellNowContainer);
			var menuButton = FindViewById(Resource.Id.MenuButton);
			menuButton.Click += (sender, e) =>
			{
				menu.AnimatedOpened = !menu.AnimatedOpened;
			};
		}
	}
}

